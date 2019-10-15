package com.uc.server.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.uc.server.Application;
import com.uc.server.domain.dao.RegionDao;
import com.uc.server.domain.entry.Loan;
import com.uc.server.domain.entry.Region;
import com.uc.server.domain.manager.LoanManager;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class AppTest {

    Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private LoanManager loanManager;

    @Autowired
    private RegionDao regionDao;

    @Test
    public void testFind() {

        logger.info("loanManager:" + loanManager);

        Loan loanEntry = loanManager.findById(6);

        logger.info("loanInfo:" + loanEntry);

        Log log = LogFactory.getLog("xxxx");
        System.out.println("=============>" + log);
        Assert.assertNotNull(loanEntry);
    }

    @Test
    public void test() {
        JSONArray array = get("1");
        System.out.println(array.toJSONString());
    }

    private JSONArray get(String code) {
        List<Region> list = regionDao.queryAll();
        Multimap<String, Region> multimap = ArrayListMultimap.create();
        for(Region region : list) {
            multimap.put(region.getParentCode(), region);
        }

        JSONArray array = getChild(code, multimap);
        return array;
    }

    private JSONArray getChild(String code,  Multimap<String, Region> multimap) {
        System.out.println(code);
        Collection<Region> collection = multimap.get(code);
        JSONArray array = new JSONArray();
        for (Region region : collection) {
            JSONArray childArray = getChild(region.getCode()+"",multimap);
            JSONObject json = new JSONObject();
            json.put("text", region.getName());
            json.put("valueCode", region.getCode());
            if (!childArray.isEmpty()) {
                json.put("children", childArray);
            }
            array.add(json);
        }
        return array;
    }


    private JSONArray get(int code){
        List<Region> list = regionDao.findByParentCode(code);
        JSONArray array = new JSONArray();
        for(Region region : list) {
            JSONArray childArray = get(region.getCode());
            JSONObject json = new JSONObject();
            json.put("text", region.getName());
            json.put("valueCode", region.getCode());
            if(!childArray.isEmpty()) {
                json.put("children", childArray);
            }
            array.add(json);
        }
        return array;
    }
}
