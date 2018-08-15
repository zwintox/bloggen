package com.example.blogg;

import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.List;

public class BloggPagination {

    public List <posts> getPostForPage(int page, List <posts> list) {


        int sizePerPage = 3;

        int from = Math.max(0, page -1 * sizePerPage);
        int to = Math.min(list.size(), (page + 1) * sizePerPage);

        return list.subList(from, to);
    }

}
