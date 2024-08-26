package org.PruebaTecnica0826.controllers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.PruebaTecnica0826.modelos.CategoriaK;
import org.PruebaTecnica0826.servicios.interfaces.ICategoriaKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/marcas")
public class CategoriaKController {

    @Autowired
  private ICategoriaKService categoriaService;

  @GetMapping
     public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
         int currentPage = page.orElse(1) - 1;
         int pageSize = size.orElse(5);
         Pageable pageable = PageRequest.of(currentPage, pageSize);

         Page<CategoriaK> marcas = categoriaService.buscarTodosPaginados(pageable);
         model.addAttribute("marcas", marcas);

         int totalPages = marcas.getTotalPages();
         if (totalPages > 0) {
             List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
         }

     return "marca/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
      model.addAttribute("marca", new CategoriaK());
      return "marca/create";
    }
  
    @PostMapping("/save")
    public String save(@ModelAttribute("marca") CategoriaK marca, BindingResult result, Model model, RedirectAttributes attributes) {
      if (result.hasErrors()) {
        model.addAttribute("marca", marca);  
  
        attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
        return "marca/create";
      }
  
      categoriaService.crearOEditar(marca);
      attributes.addFlashAttribute("msg", "Categoria creada correctamente");
      return "redirect:/marcas";
    }
  
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
      Optional<CategoriaK> marca = categoriaService.buscarPorId(id);
      if (marca.isPresent()) {
        model.addAttribute("marca", marca.get());
        return "marca/details";
      } else {
        return "redirect:/marcas";
      }
    }
  
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
      Optional<CategoriaK> marca = categoriaService.buscarPorId(id);
      if (marca.isPresent()) {
        model.addAttribute("marca", marca.get());
        return "marca/edit";
      } else {
        return "redirect:/marcas";
      }
    }
  
    @PostMapping("/update")
    public String update(@ModelAttribute("marca") CategoriaK marca, BindingResult result, Model model, RedirectAttributes attributes) {
      if (result.hasErrors()) {
        model.addAttribute("marca", marca);
        return  
   "marca/edit";
      }
  
      categoriaService.crearOEditar(marca);
      attributes.addFlashAttribute("msg", "Categoria actualizada correctamente");
      return "redirect:/marcas";
    }
  
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model){
        CategoriaK categoriaK = categoriaService.buscarPorId(id).get();
        model.addAttribute("marca", categoriaK);
        return "marca/delete";
    }
  
    @PostMapping("/delete")
    public String delete(CategoriaK categoria, RedirectAttributes attributes){
      categoriaService.eliminarPorId(categoria.getId());
      attributes.addFlashAttribute("msg", "Categoria eliminada correctamente");
      return "redirect:/marcas";
  }


}
