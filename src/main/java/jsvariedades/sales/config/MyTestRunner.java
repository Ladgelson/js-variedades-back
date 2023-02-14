package jsvariedades.sales.config;

import jsvariedades.sales.repository.*;
import jsvariedades.sales.service.ProductService;
import jsvariedades.sales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyTestRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SaleService saleService;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public void run(String... args) throws Exception {

//        var companyModel = companyRepository.findById(1L).get();
        System.out.println(passwordEncoder.encode("123456"));
////        System.out.println();
//        RoleModel user = new RoleModel(RoleType.ROLE_USER);
//        roleRepository.save(user);
//
//        UserModel micaias = new UserModel()
//                .setUsername("Micaias")
//                .setEmail("micaiasladgelsondasilva@gmail.com")
//                .setActive(true)
//                .setPassword("123456")
//                .setImgLink("www.google.com")
//                .setRole(user);
//        userRepository.save(micaias);
//
//        CompanyModel companyModel = new CompanyModel()
//                .setCnpj("123456789435")
//                .setName("JS Variedades");
//        companyRepository.save(companyModel);
//
//        micaias.setCompany(companyModel);
//        userRepository.save(micaias);
//
//        var dinheiro = new PaymentTypeModel().setType(PaymentType.MONEY);
//        var pix = new PaymentTypeModel().setType(PaymentType.PIX);
//
//        paymentTypeRepository.saveAll(List.of(dinheiro, pix));
//
//        StoreModel storeModel = new StoreModel()
//                .setCompany(companyModel)
//                .setName("JS Variedades Barauna");
//
//        storeRepository.save(storeModel);
//        storeModel.toString();
//
//        var comp = companyRepository.findById(1L).get();
//        StoreModel storeModel2 = new StoreModel()
//                .setCompany(comp)
//                .setName("JS Variedades Fortim");
//        storeRepository.save(storeModel2);
//
//        var categ = new CategoryModel()
//                .setName("Copos e Chicaras");
//
//        categoryRepository.save(categ);
//
//        var product = new ProductModel()
//                .setDescription("Chicara Azul de Borda amarela")
//                .setName("Chiraca Azul")
//                .setPurchasePrice(BigDecimal.valueOf(2.40))
//                .setSaleValue(BigDecimal.valueOf(4.40))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        productRepository.save(product);
//
////        var user = userRepository.findById(1L).get();
//        var product2 = new ProductModel()
//                .setDescription("Chicara Verde de Borda vermelha")
//                .setName("Chiraca Verde")
//                .setPurchasePrice(BigDecimal.valueOf(2.40))
//                .setSaleValue(BigDecimal.valueOf(4.40))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        productRepository.save(product2);
//
//        var like = new LikeModel()
//                .setUser(micaias)
//                .setProductModel(product2);
//
//        likeRepository.save(like);
//        like.toString();
//
//        var sale = saleService.initSale();
//        saleService.addItem(1L,
//                new SaleItemRequest()
//                        .setProductId(product.getId())
//                        .setQuantity(6)
//                        .setValue(product.getSaleValue())
//        );

//        saleService.finishSale(1L);

//        var storeModel = storeRepository.findById(1L).get();
//        var categ = categoryRepository.findById(1L).get();
//
//        var product1 = new ProductModel()
//                .setDescription("Chicara Verde de Borda vermelha")
//                .setName("Chiraca Verde")
//                .setPurchasePrice(BigDecimal.valueOf(2.40))
//                .setSaleValue(BigDecimal.valueOf(4.40))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product2 = new ProductModel()
//                .setDescription("Pano de prato")
//                .setName("Pano de prato")
//                .setPurchasePrice(BigDecimal.valueOf(1.40))
//                .setSaleValue(BigDecimal.valueOf(3.20))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product3 = new ProductModel()
//                .setDescription("Bolsa Hellokit")
//                .setName("Bolsa Hellokit")
//                .setPurchasePrice(BigDecimal.valueOf(24.40))
//                .setSaleValue(BigDecimal.valueOf(55.00))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product4 = new ProductModel()
//                .setDescription("Notebook Dell i7")
//                .setName("Notebook Dell")
//                .setPurchasePrice(BigDecimal.valueOf(2300.00))
//                .setSaleValue(BigDecimal.valueOf(3500.60))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product5 = new ProductModel()
//                .setDescription("Computador de mesa")
//                .setName("Computador")
//                .setPurchasePrice(BigDecimal.valueOf(1500.00))
//                .setSaleValue(BigDecimal.valueOf(2390.40))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product6 = new ProductModel()
//                .setDescription("Mouse Gamer")
//                .setName("Mouse")
//                .setPurchasePrice(BigDecimal.valueOf(66.50))
//                .setSaleValue(BigDecimal.valueOf(114.40))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product7 = new ProductModel()
//                .setDescription("Cabo HDMI")
//                .setName("Cabo")
//                .setPurchasePrice(BigDecimal.valueOf(10.00))
//                .setSaleValue(BigDecimal.valueOf(17.50))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product8 = new ProductModel()
//                .setDescription("Caderno capa duro")
//                .setName("Caderno")
//                .setPurchasePrice(BigDecimal.valueOf(25.50))
//                .setSaleValue(BigDecimal.valueOf(45.50))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product9 = new ProductModel()
//                .setDescription("Fone de ouvido.")
//                .setName("Fone")
//                .setPurchasePrice(BigDecimal.valueOf(20.00))
//                .setSaleValue(BigDecimal.valueOf(35.00))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//        var product10 = new ProductModel()
//                .setDescription("Teclado Gamer")
//                .setName("Teclado")
//                .setPurchasePrice(BigDecimal.valueOf(16.40))
//                .setSaleValue(BigDecimal.valueOf(25.00))
//                .setStore(storeModel)
//                .setCategory(categ);
//
//
//        productRepository.saveAll(Arrays.asList(product1,product2,product3,product5,product5,product6,product7,product8,product9,product10 ));
//        productService.findAllPaginated(null, 1L, null, null);
//        productService.findAllPaginated(1,"pano", null, true, null);
//        productService.findAllPaginated(null, null, null, false);
//        productService.findAllPaginated(0,null, null, true, null);
//        productService.findAllPaginated(1,null, null, true, null);
//        productService.findAllPaginated(2,null, null, true, null);
    }


}
