package com.qapropsoft.carina.demo.db.mappers;

import com.qapropsoft.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
