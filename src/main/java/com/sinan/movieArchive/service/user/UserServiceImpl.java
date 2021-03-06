package com.sinan.movieArchive.service.user;

import com.sinan.movieArchive.dao.entity.UserEntity;
import com.sinan.movieArchive.dao.repository.UserRepository;
import com.sinan.movieArchive.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service handles operations related to UserEntity
 *
 * @author Pezhman Jahanmard
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserRepository> implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserEntity findUser(Integer userId) throws UserServiceException {
		UserEntity userEntity = repository.findOne(userId);
		if (userEntity == null) {
			throw new UserServiceException("User #" + userId + " not found");
		}

		return userEntity;
	}
}
