package FunctionalInterFaceExample;
import java.net.ProxySelector;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


class Product{
    //Fields
    int productId;
    String productTitle;
    LocalDate expiryDate;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }

    //Constructor
    public Product(int productId, String productTitle, LocalDate expiryDate) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.expiryDate = expiryDate;
    }

    //Getter Methods
    public int getProductId() {
        return productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}

class FunctionalInterfaceDemo{
    private List<Product> productList;

    public FunctionalInterfaceDemo() {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Samsung", LocalDate.of(2025,04,22)));
        productList.add(new Product(2,"Apple", LocalDate.of(2025,07,12)));
        productList.add(new Product(3,"OnePlus", LocalDate.of(2025,05,5)));
    }

    //1. Predicate : Filter Product Based on their Date of Expiry
    public List<Product> filteredProducts (Predicate<Product> criteria){
        List<Product> filteredProducts = new ArrayList<>();
        for(Product product:productList){
            if(criteria.test(product)){
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    //2. Consumer process each product without returning a product
    public void displayProduct(Consumer<Product> productDetails){
        for (Product product:productList) {
            productDetails.accept(product);
        }
    }

    //3. Function Extract all products title and return it
    public List<String> mapProductTitles(Function<Product,String> mapper){
        List<String> titles = new ArrayList<>();
        for (Product product:productList) {
            titles.add(mapper.apply(product));
        }
        return titles;
    }

    //4. Supplier Generate a default product if there is no products
    public Product getDefaultProduct(Supplier<Product> defaultProductSupplier) {
        return productList.isEmpty() ? defaultProductSupplier.get() : productList.get(0);
    }

    public static void main(String[] args) {
        FunctionalInterfaceDemo productCart = new FunctionalInterfaceDemo();

        //Predicate
        System.out.println("Product Expiry Before 1-2-25 using Predicate :- ");
        List<Product> filteredProducts = productCart.filteredProducts(product -> product.getExpiryDate().isBefore(LocalDate.of(2025,2,1)));

        //Consumer
        System.out.println("Display Product Details using Consumer :- ");
        productCart.displayProduct(product -> System.out.println("ID :- "+product.getProductId()+"  ||  Title :- "+product.getProductTitle()+"  || Expiry Date :- "+product.getExpiryDate()));

        //Function
        System.out.println("Maps Each Product with its title and return list using Function :- ");
        List<String> titles = productCart.mapProductTitles(product -> product.getProductTitle());
        titles.forEach(System.out::println);

        //Supplier
        System.out.println("Default Product :- ");
        Product defaultProduct = productCart.getDefaultProduct(()->new Product(0,"Product Title",LocalDate.of(2000,1,1)));
        System.out.println(defaultProduct);
    }
}