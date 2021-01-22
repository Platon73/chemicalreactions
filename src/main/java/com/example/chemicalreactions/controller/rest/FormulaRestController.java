package com.example.chemicalreactions.controller.rest;

import com.example.chemicalreactions.service.AtomService;
import com.example.chemicalreactions.service.ChemicalReactionService;
import com.example.chemicalreactions.service.MoleculeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formula/rest")
public class FormulaRestController {

    private final AtomService atomService;

    private final ChemicalReactionService chemicalReactionService;

    private final MoleculeService moleculeService;

    public FormulaRestController(AtomService atomService,
                                 ChemicalReactionService chemicalReactionService,
                                 MoleculeService moleculeService) {
        this.atomService = atomService;
        this.chemicalReactionService = chemicalReactionService;
        this.moleculeService = moleculeService;
    }


    @PostMapping("/string")
    public String creat(@RequestBody String stringFormula) {
        String strFormuladb = chemicalReactionService.findAllChemicalReaction().stream().findFirst().get().getStringChemicalReaction();
        if (strFormuladb.equals(stringFormula)) {
            return strFormuladb;
        }
        String str = "нет такой формулы";
        return str;
    }

    public String parsingStringFormulas(String strFormula){
        String[] str = strFormula.split(" ");
        return " "; 
    }

}
