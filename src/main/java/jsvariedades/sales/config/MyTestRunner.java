package jsvariedades.sales.config;

import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.enums.PaymentType;
import jsvariedades.sales.model.*;
import jsvariedades.sales.repository.*;
import jsvariedades.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

//@Configuration
public class MyTestRunner  {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private CompanyRepository companyRepository;
//
//    @Autowired
//    private StoreRepository storeRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    private LikeRepository likeRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private SaleService saleService;
//
//    @Autowired
//    private PaymentTypeRepository paymentTypeRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
////        var companyModel = companyRepository.findById(1L).get();
////        System.out.println(passwordEncoder.encode("123456"));
////        System.out.println();
////        RoleModel user = new RoleModel(RoleType.USER);
////        roleRepository.save(user);
////
////        UserModel micaias = new UserModel()
////                .setUsername("Micaias")
////                .setEmail("micaiasladgelsondasilva@gmail.com")
////                .setActive(true)
////                .setPassword("123456")
////                .setImgLink("www.google.com")
////                .setRole(user);
////        userRepository.save(micaias);
////
////        CompanyModel companyModel = new CompanyModel()
////                .setCnpj("123456789435")
////                .setName("JS Variedades");
////        companyRepository.save(companyModel);
////
////        micaias.setCompany(companyModel);
////        userRepository.save(micaias);
////
////        var dinheiro = new PaymentTypeModel().setType(PaymentType.MONEY);
////        var pix = new PaymentTypeModel().setType(PaymentType.PIX);
////
////        paymentTypeRepository.saveAll(List.of(dinheiro, pix));
////
////        StoreModel storeModel = new StoreModel()
////                .setCompany(companyModel)
////                .setName("JS Variedades Barauna");
////
////        storeRepository.save(storeModel);
////        storeModel.toString();
////
////        var comp = companyRepository.findById(1L).get();
////        StoreModel storeModel2 = new StoreModel()
////                .setCompany(comp)
////                .setName("JS Variedades Fortim");
////        storeRepository.save(storeModel2);
////
////        var categ = new CategoryModel()
////                .setName("Copos e Chicaras");
////
////        categoryRepository.save(categ);
////
////        var product = new ProductModel()
////                .setDescription("Chicara Azul de Borda amarela")
////                .setName("Chiraca Azul")
////                .setPurchasePrice(BigDecimal.valueOf(2.40))
////                .setSaleValue(BigDecimal.valueOf(4.40))
////                .setStore(storeModel)
////                .setCategory(categ);
////
////        productRepository.save(product);
////
////        var user = userRepository.findById(1L).get();
////        var product2 = new ProductModel()
////                .setDescription("Chicara Verde de Borda vermelha")
////                .setName("Chiraca Verde")
////                .setPurchasePrice(BigDecimal.valueOf(2.40))
////                .setSaleValue(BigDecimal.valueOf(4.40))
////                .setStore(storeModel)
////                .setCategory(categ);
////
////        productRepository.save(product2);
////
////        var like = new LikeModel()
////                .setUser(user)
////                .setProductModel(product2);
////
////        likeRepository.save(like);
////        like.toString();
//
////        var sale = saleService.initSale();
////        var product = productRepository.findById(1L).get();
////        saleService.addItem(1L,
////                new SaleItemRequest()
////                        .setProductId(product.getId())
////                        .setQuantity(6)
////                        .setValue(product.getSaleValue())
////        );
//
////        saleService.finishSale(1L);
//    }
}
