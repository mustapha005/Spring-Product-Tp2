package org.example.springmvc2.web;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.example.springmvc2.entities.Product;
import org.example.springmvc2.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name="keyword", defaultValue="") String keyword) {
        // On utilise notre nouvelle méthode de recherche
        List<Product> products = productRepository.findByNameContains(keyword);
        model.addAttribute("productList", products);
        model.addAttribute("keyword", keyword); // On renvoie le mot-clé pour le garder dans la barre de recherche
        return "products";
    }

    @GetMapping("/")
    public String home() {

        return "redirect:/user/index";
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam(name="id") Long id, RedirectAttributes redirectAttributes) {
        productRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Le produit a été supprimé avec succès !");

        return "redirect:/user/index";

    }

    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";

    }

    @PostMapping("/admin/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult , RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors())
            return "new-product";
        productRepository.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Le produit a été ajouté avec succès !");

        return "redirect:/admin/newProduct";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }


    @GetMapping("/admin/editProduct")
    public String editProduct(Model model, @RequestParam(name="id") Long id) {
        // On va chercher le produit dans la base
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "edit-product"; // On va créer cette vue
    }

}
