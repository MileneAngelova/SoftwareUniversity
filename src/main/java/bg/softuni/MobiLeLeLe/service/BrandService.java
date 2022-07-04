package bg.softuni.MobiLeLeLe.service;

import bg.softuni.MobiLeLeLe.Model.DTO.BrandDTO;
import bg.softuni.MobiLeLeLe.Model.DTO.ModelDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.BrandEntity;
import bg.softuni.MobiLeLeLe.Model.Entity.ModelEntity;
import bg.softuni.MobiLeLeLe.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandDTO> getAllBrands() {
        return brandRepository.
                findAll().
                stream().
                map(this::mapBrand).
                collect(Collectors.toList());
    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {
        List<ModelDTO> models = brandEntity.
                getModels().
                stream().
                map(this::mapModel).
                toList();

        return new BrandDTO().
                setModels(models).
                setName(brandEntity.getName());
    }

    private ModelDTO mapModel(ModelEntity modelEntity) {
        return new ModelDTO().
                setId(modelEntity.getId()).
                setName(modelEntity.getName());
    }

}
