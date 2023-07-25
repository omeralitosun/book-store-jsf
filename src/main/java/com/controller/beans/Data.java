package com.controller.beans;

import com.entities.enums.Genre;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Data {

	public Genre[] getStatuses() {
        return Genre.values();
    }
}
