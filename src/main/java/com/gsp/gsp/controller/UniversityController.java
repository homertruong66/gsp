package com.gsp.gsp.controller;

import com.google.gson.Gson;
import com.gsp.gsp.model.University;
import com.gsp.gsp.util.DBUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @GetMapping("/alluni")
    public String getAllUni(){
        List<University> list = DBUtil.getUni("SELECT * FROM university");
        return new Gson().toJson(list);
    }

    @PostMapping("/insert")
    public String insertUni( @RequestParam String nameUni, @RequestParam String abbrNameUni,
                           @RequestParam String addressUni,@RequestParam String typeUni){
        String id = UUID.randomUUID().toString().replace("-", "");
        String sql = "INSERT INTO `university` " +
                "VALUES ( '" + id +"','" + nameUni + "','" + abbrNameUni + "','" + addressUni + "','" + typeUni + "') ";
        DBUtil.updateUni(sql);
        return "success";
    }

    @PostMapping("/update")
    public String updateUni(@RequestParam String idUni, @RequestParam String nameUni,
                            @RequestParam String abbrNameUni,@RequestParam String addressUni,
                            @RequestParam String typeUni ){
        String sql = "UPDATE university " +
                "SET nameUni = '" + nameUni + "' ,abbrNameUni = '" + abbrNameUni + "',addressUni = '" + abbrNameUni + "',typeUni = '" + typeUni + "' " +
                " WHERE idUni = '" + idUni + "' ";
        DBUtil.updateUni(sql);
        return "success";
    }
}
