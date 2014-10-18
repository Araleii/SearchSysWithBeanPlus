package com.search.Dao;

import com.search.entity.Datainfo;

public interface SearchDao {
      public String[] getSearchList(Datainfo datainfo);
      public String[] getTitle(Datainfo datainfo);
      public String[] getSearchListMulti(Datainfo datainfo);
}
