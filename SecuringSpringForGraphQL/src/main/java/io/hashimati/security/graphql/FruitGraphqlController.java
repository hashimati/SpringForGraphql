package io.hashimati.security.graphql;


import io.hashimati.security.domains.Fruit;
import io.hashimati.security.reposiotries.FruitRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class FruitGraphqlController {
    private final FruitRepository fruitRepository;

    public FruitGraphqlController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Secured(value = "ROLE_USER")
    @QueryMapping
    public Fruit findById(@Argument Integer id)
    {
        return fruitRepository.findById(Long.valueOf(id.intValue())).orElse(null);

    }

    @Secured(value = "ROLE_USER")
    @QueryMapping
    public List<Fruit> findAll()
    {
        return fruitRepository.findAll();
    }

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @MutationMapping
    public Fruit save(@Argument Fruit fruit)
    {
        return fruitRepository.save(fruit);
    }

}
