package com.sparta.springcore.util;

import com.sparta.springcore.model.Comment;
import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {

    public static Specification<Comment> withmemo_id(Long memo_id) {
        return ((root, query, builder) ->
                builder.equal(root.get("memo_id"), memo_id)
        );
    }
}