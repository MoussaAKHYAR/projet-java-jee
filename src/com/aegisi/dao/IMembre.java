package com.aegisi.dao;

import com.aegisi.entities.Membre;

import java.util.List;

public interface IMembre {
    public int add(Membre membre);
    public List<Membre> list();
}
