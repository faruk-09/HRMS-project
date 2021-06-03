package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class UserManager implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users are Listed");
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User is Added");
	}


	@Override
	public Result update(int id, User user) {
		if(userDao.getOne(id) == null) {
			return new ErrorResult("User Does not Exist");
		}
		
		userDao.save(user);
		
		return new SuccessResult("User is Updated");
	}
	
	@Override
	public Result delete(int id) {
		if(userDao.getOne(id) == null) {
			return new ErrorResult("Id of User is Null");
		}
		
		userDao.deleteById(id);

		return new SuccessResult("User is Deleted");
	}

}
