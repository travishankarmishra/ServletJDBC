package com.service;

import java.util.ArrayList;

import com.model.FormModel;

public interface FormService {

	boolean insert(FormModel fm) throws Exception;

	ArrayList<FormModel> fetchAllData();
}
