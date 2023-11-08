package org.yurov.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.yurov.model.Base;
import org.yurov.service.BaseService;

import java.util.List;
@Slf4j
@Controller
public class BaseController {
    private final BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }


    //контроллер для отображения информации с таблицы на главной странице
    @GetMapping("/")
    public String findAll(Model model) {
        List<Base> bases = baseService.findAll();
        model.addAttribute("bases", bases);
        return "main-page";
    }

    //контроллер для добавление записи в реестр
    @GetMapping("/create-record-database")
    public String createRecordToTheDatabaseForm(Base base) {
        return "create-record-database";
    }

    @PostMapping("/create-record-database")
    public String createRecordToTheDatabase(Base base) {
        baseService.saveBase(base);
        return "redirect:/";
    }

    //удаление записи в реестре
    @GetMapping("delete-record-database/{id}")
    public String deleteRecordToTheDatabase(@PathVariable("id") Long id) {
        baseService.deleteById(id);
        return "redirect:/";
    }

    //редактирование записи по базе
    @GetMapping("/update-record-database/{id}")
    public String editRecordToTheDatabaseForm(@PathVariable("id") Long id, Model model) {
        Base base = baseService.findById(id);
        model.addAttribute("base", base);
        return "/update-record-database";
    }

    @PostMapping("/update-record-database")
    public String editRecordToTheDatabase(Base base) {
        baseService.saveBase(base);
        return "redirect:/";
    }
    //поиск по владельцу
    @GetMapping("search-by-owner/{searchOwner}")
    public String findBaseByOwnerForm(@PathVariable("searchOwner") String searchOwner, Model model) {
        List<Base> searchBaseByOwner = baseService.findByOwner(searchOwner);
        model.addAttribute("bases", searchBaseByOwner);
        if(searchBaseByOwner.isEmpty()){
            return "error-search";
        }
        return "search-by-owner";
    }

    @PostMapping("/search-by-owner/")
    public String findBaseByOwner(Base base) {
        baseService.findByOwner(base.getBaseOwner());
        return "redirect:/";
    }
}
