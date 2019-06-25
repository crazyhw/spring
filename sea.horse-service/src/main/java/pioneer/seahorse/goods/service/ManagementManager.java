package pioneer.seahorse.goods.service;
import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.goods.domain.Management;

import java.util.List;
/**
 *
 * @author lpl
 * @Date  2019/4/28 14:34
 *
 */
public interface ManagementManager extends GenericTreeManager<Management, Long> {
    List<Management> getAll();
    Management findbyManagementId(Long Id);
    Boolean deletebyManagementId(Long Id);
    Management findbyManagementName(String name);
    void reduce(Management market);
    void updata();
    Boolean addManagement( Management market);
    Boolean updateManagement( Management market);
    public Management search( String name);
}
