package pioneer.seahorse.pay.service;
import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.pay.domain.Shop;
import java.util.List;
/**
 * @author lvqingyv
 * @date 2019/6/21 19:58
 */
public interface ShopManager extends GenericTreeManager<Shop, Long> {
    List<Shop> getAll();

   Shop findbyShopId(Long id);

    Boolean deletebyShopId(Long id);

    Shop findbyShopName(String name);
}
