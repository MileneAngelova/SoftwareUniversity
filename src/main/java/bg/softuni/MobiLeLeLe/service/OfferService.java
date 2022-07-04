package bg.softuni.MobiLeLeLe.service;

import bg.softuni.MobiLeLeLe.Model.DTO.AddOfferDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.ModelEntity;
import bg.softuni.MobiLeLeLe.Model.Entity.OfferEntity;
import bg.softuni.MobiLeLeLe.Model.Entity.UserEntity;

import bg.softuni.MobiLeLeLe.Model.mapper.OfferMapper;
import bg.softuni.MobiLeLeLe.repository.ModelRepository;
import bg.softuni.MobiLeLeLe.repository.OfferRepository;
import bg.softuni.MobiLeLeLe.repository.UserRepository;
import bg.softuni.MobiLeLeLe.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository,
                        UserRepository userRepository,
                        ModelRepository modelRepository,
                        CurrentUser currentUser,
                        OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    public void addOffer(AddOfferDTO addOfferDTO) {
        OfferEntity newOffer = offerMapper.
                addOfferDtoToOfferEntity(addOfferDTO);

        // TODO - current user should be logged in
        UserEntity seller = userRepository.findByEmail(currentUser.getEmail()).
                orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).
                orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        offerRepository.save(newOffer);
    }
}
