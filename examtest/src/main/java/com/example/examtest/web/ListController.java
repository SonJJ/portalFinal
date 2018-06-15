package com.example.examtest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ListController {
    private final ListRepository listRepository;
    private List<ListData> listDatas = new ArrayList<ListData>();

    @Autowired
    public ListController(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @GetMapping("/create")
    public String create() {
        return "data/addList";
    }
    @GetMapping("/detail")
    public String more(){
        return "detail";
    }

    @PostMapping("/save")
    public String save(ListData listData){
        listRepository.save(listData);
        return "redirect:/data/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("lists", listRepository.findAll());
        return "data/list";
    }

    @GetMapping("/edit")
    public ListData get(@PathVariable("list_id") Integer list_id){
        return listRepository.findById(list_id).get();
    }


    @PostMapping("/update")
    public String update(ListData listData){
        System.out.println(listData.toString());
        return "updatePage";
    }


    @GetMapping("/remove")
    public String delet(ListData listData){
        System.out.println(listData.toString());
        return "delPage";
    }




}
