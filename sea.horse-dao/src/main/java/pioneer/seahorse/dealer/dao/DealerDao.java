package pioneer.seahorse.dealer.dao;
import org.springframework.stereotype.Repository;
import pioneer.seahorse.base.dao.GenericDao;
import pioneer.seahorse.dealer.domain.Dealer;
@Repository("dealerDao")

public interface DealerDao extends GenericDao<Dealer, Long>{
}
