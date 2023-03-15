package com.FrameWork.FundamentosSpringBoot.repository;

import com.FrameWork.FundamentosSpringBoot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
