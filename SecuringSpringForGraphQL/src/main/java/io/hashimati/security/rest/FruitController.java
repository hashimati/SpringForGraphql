package io.hashimati.security.rest;

import io.hashimati.security.domains.Fruit;
import io.hashimati.security.reposiotries.FruitRepository;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class FruitController {

    private FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GetMapping("/findAll")
    public Iterable<Fruit> findAll(){
        return fruitRepository.findAll();
    }


    @PostMapping("/save")
    public Fruit saveFruits(@RequestBody  Fruit fruit){

        return fruitRepository.save(fruit);
    }
    @GetMapping("/saveDummy")
    public Fruit saveDummy()
    {
        Fruit fruit
                = new Fruit();
        fruit.setName("Apple");
        fruit.setLetter("A");
        return fruitRepository.save(fruit);

    }

}
