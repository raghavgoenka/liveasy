package com.liveasy.liveasy.services;

import com.liveasy.liveasy.Dao.LoadDao;
import com.liveasy.liveasy.entities.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoadServicesImpl implements LoadServices {

    List<Load>list;
    @Autowired
    private LoadDao loadDao;

    public LoadServicesImpl(){
        list=new ArrayList<>();
        list.add(new Load("Delhi","Jaipur","chemicals",
                "canter",1,100,"hazardous",54321,"2022-08-06"));
    }
    @Override
    public List<Load> getLoad() {
         return loadDao.findAll();
    }
    @Override
    public Load getLoadById(Integer loadId) {
        return loadDao.getReferenceById(loadId);
    }
    @Override
    public  Load addLoad(Load load)
    {
        loadDao.save(load);
        return load;
    }
    @Override
    public Load updateLoad(Load load)
    {
//        list.forEach(l->{
//            if(l.getShipperId()==load.getShipperId())
//            {
//                l.setLoadingPoint(load.getLoadingPoint());
//                l.setUnloadingPoint(load.getUnloadingPoint());
//                l.setProductType(load.getProductType());
//                l.setNoOfTrucks(load.getNoOfTrucks());
//                l.setTruckType(load.getTruckType());
//                l.setWeight(load.getWeight());
//                l.setComment(load.getComment());
//                l.setDate(load.getDate());
//            }
//        });
        loadDao.save(load);
        return load;
    }

    public  void deleteLoad(Integer loadId)
    {
        loadDao.deleteById(loadId);
    }
}
