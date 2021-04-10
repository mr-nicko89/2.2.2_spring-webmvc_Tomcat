package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.dao.PersonDAO;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String index(@RequestParam(value = "count", required = false) Integer count, Model model) {
        //Получим все автомобили из DAO и передадим на отображение в представление
        if (count == null) {
            model.addAttribute("cars", carDAO.index());
        } else {
            model.addAttribute("cars", carDAO.index(count));
        }
        model.addAttribute("carsAmount", carDAO.carsAmount());
        return "cars/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //Получим одного человека по id из DAO и передадим на отображение в представление
        model.addAttribute("cars", carDAO.show(id));
        return "cars/show";
    }
}
