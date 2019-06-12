package pioneer.seahorse.cargo_shelves.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.cargo_shelves.domain.Shelves;
import java.util.List;
/**
 *
 * @author 任鑫意
 * @Date  2019/4/26 17:05
 *
 */
public interface ShelvesManager extends GenericTreeManager<Shelves, Long> {
    List<Shelves> getAll();
}
