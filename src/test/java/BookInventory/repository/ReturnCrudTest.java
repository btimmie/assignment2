package BookInventory.repository;

import BookInventory.App;
import BookInventory.config.factory.ReturnFactory;
import BookInventory.domain.Customer;
import BookInventory.domain.Return;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ReturnCrudTest {
    private Long id;

    @Autowired
    ReturnRepository repository;
    @Test
    public void aCreate() throws Exception{
        List<Customer> customerList = new ArrayList<Customer>();

        Map<String,String> values = new HashMap<String,String>();
        values.put("code","54ZTY");

        Return rt = ReturnFactory
                .createReturn(5,values,customerList);
        //repository.save(rt);
        Assert.assertNotNull(rt);

    }

    @Test
    public void bRead() throws Exception{
        Return rt = repository.findOne(id);
        Assert.assertEquals("54ZTY",rt.getCode());
    }

    @Test
    public void cTestUpdate() throws Exception{
        Return rt = repository.findOne(id);
        Return newreturn = new Return.Builder("54ZTY").quantity(6).build();
        repository.save(newreturn);
        Assert.assertEquals(6,newreturn.getQuantity());

    }

    @Test
    public void dDelete() throws Exception{
        Return rt = repository.findOne(id);
        repository.delete(rt);
        Return newReturn = repository.findOne(id);
        Assert.assertNull(newReturn);
    }
}
