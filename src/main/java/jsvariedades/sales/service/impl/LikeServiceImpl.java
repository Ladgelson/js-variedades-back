package jsvariedades.sales.service.impl;

import jsvariedades.sales.model.LikeModel;
import jsvariedades.sales.repository.LikeRepository;
import jsvariedades.sales.service.LikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void save(LikeModel likeModel) {
        likeRepository.save(likeModel);
    }
}
