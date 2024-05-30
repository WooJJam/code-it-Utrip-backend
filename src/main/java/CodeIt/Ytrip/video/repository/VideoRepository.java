package CodeIt.Ytrip.video.repository;

import CodeIt.Ytrip.like.domain.VideoLike;
import CodeIt.Ytrip.user.domain.User;
import CodeIt.Ytrip.video.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findTop12ByOrderByLikeCountDesc();
}
