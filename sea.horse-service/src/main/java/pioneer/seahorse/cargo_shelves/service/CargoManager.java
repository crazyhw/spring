package pioneer.seahorse.cargo_shelves.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.cargo_shelves.domain.Cargo;

import java.util.List;
/**
 *
 * @author 任鑫意
 * @Date  2019/4/26 17:05
 *
 */
public interface CargoManager extends GenericManager<Cargo, Long> {

    List<Cargo> getAll();

}
