package com.fatiq.restful_api.social_media.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatiq.restful_api.social_media.entity.User;

public interface PostJpaRepository extends JpaRepository<Post, Integer>{

}
