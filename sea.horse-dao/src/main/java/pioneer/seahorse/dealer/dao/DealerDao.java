package pioneer.seahorse.dealer.dao;
import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.dealer.domain.Dealer;
/**
 * DealerDao
 * @author 白疆银
 * @Date  2019/3/24 13:28
 */
@Repository("dealerDao")
public interface DealerDao extends GenericDao<Dealer, Long>{
}
