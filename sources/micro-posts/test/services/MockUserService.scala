package services

import models.User
import scalikejdbc.DBSession
import models.{PagedItems, User}
import skinny.Pagination

import scala.util.{ Success, Try }

class MockUserService extends UserService {

  override def create(user: User)(implicit dbSession: DBSession): Try[Long] = Success(1L)

  override def findByEmail(email: String)(implicit dbSession: DBSession): Try[Option[User]] =
    Success(Some(User(Some(1L), email, email, "xxx")))

  override def findAll(pagination: Pagination)(implicit dbSession: DBSession): Try[PagedItems[User]] =
    Success(PagedItems(pagination, 10, List(User(Some(1L), "test", "test@test.coml", "xxx"))))

  override def findById(id: Long)(implicit dbSession: DBSession): Try[Option[User]] =
    Success(Some(User(Some(1L), "test", "test@test.coml", "xxx")))

}
