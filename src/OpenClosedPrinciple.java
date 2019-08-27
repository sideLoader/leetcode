
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Color { RED, BLUE, GREEN }
enum Size { LARGE, MEDIUM, SMALL }

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}

// old filter
class ProductFilter {

    public Stream<Product> colorFilter(List<Product> productList, Color color) {
        return productList.stream().filter(product -> product.color == color);
    }

    public Stream<Product> sizeFilter(List<Product> productList, Size size) {
        return productList.stream().filter(product -> product.size == size);
    }

}

// filtering with OCP

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpec implements Specification<Product> {
    private Color color;
    public ColorSpec(Color color) { this.color = color; }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpec implements Specification<Product> {
    private Size size;
    public SizeSpec(Size size) { this.size = size; }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(item -> spec.isSatisfied(item));
    }
}

class ListAndSpecification implements Specification<Product> {
    private List<Specification<Product>> listSpec;
    public ListAndSpecification(List<Specification<Product>> listSpec) { this.listSpec = listSpec; }

    @Override
    public boolean isSatisfied(Product item) {
        for(Specification<Product> spec : listSpec)
            if(spec.isSatisfied(item) == false)
                return false;

        return true;
    }
}

class ListOrSpecification implements Specification<Product> {
    private List<Specification<Product>> listSpec;
    public ListOrSpecification(List<Specification<Product>> listSpec) { this.listSpec = listSpec; }

    @Override
    public boolean isSatisfied(Product item) {
        for(Specification<Product> spec : listSpec)
            if(spec.isSatisfied(item)) return true;

        return false;
    }
}

public class OpenClosedPrinciple {
    public static void main(String args[]) {
        List<Product> products = Arrays.asList(
                new Product("p1", Color.BLUE, Size.LARGE),
                new Product("p2", Color.GREEN, Size.LARGE),
                new Product("p3", Color.RED, Size.MEDIUM),
                new Product("p4", Color.BLUE, Size.SMALL)
        );

     //   ProductFilter productFilter = new ProductFilter();
     //   productFilter.colorFilter(products, Color.BLUE).forEach(x -> System.out.print(x));

        BetterFilter bf = new BetterFilter();
        bf.filter(products, new ColorSpec(Color.BLUE)).forEach(x -> System.out.print(x));
        bf.filter(products, new SizeSpec(Size.MEDIUM)).forEach(x -> System.out.println(x));

        System.out.println();

        bf.filter(products, new ListAndSpecification(Arrays.asList(
                new ColorSpec(Color.BLUE),
                new SizeSpec(Size.SMALL)))).forEach(x -> System.out.println(x));

        bf.filter(products, new ListOrSpecification(Arrays.asList(
                new SizeSpec(Size.LARGE),
                new ColorSpec(Color.RED)))).forEach(x -> System.out.println(x));


    }
}