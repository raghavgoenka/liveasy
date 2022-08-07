package com.liveasy.liveasy.services;

import com.liveasy.liveasy.entities.Load;

import java.util.List;

public interface LoadServices {

    public List<Load> getLoad();
    public Load getLoadById(Integer loadId);

   public Load addLoad(Load load);

   public  Load updateLoad(Load load);

    public void deleteLoad(Integer loadId);
}
