package CodeIt.Ytrip.user.controller;

import CodeIt.Ytrip.course.dto.CourseListDto;
import CodeIt.Ytrip.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    /**
     * 유저가 생성한 코스를 가져온다.
     * @param userId
     * @return UserCourseResponse
     */

    @GetMapping("/{user_id}/course")
    public ResponseEntity<?> getUserCourse(@PathVariable("user_id") Long userId) {
        return userService.findUserCourse(userId);
    }

    /**
     * 유저가 저장한 Video를 가져온다.
     * @param userId
     * @return VideoLikeDto
     */
    @GetMapping("/{user_id}/video")
    public ResponseEntity<?> getUserLikeVideo(@PathVariable("user_id") Long userId) {
        return userService.getUserLikeVideo(userId);
    }

    @DeleteMapping("/{user_id}/video/{video_id}")
    public ResponseEntity<?> deleteUserLikeVideo(@PathVariable("user_id") Long userId, @PathVariable("video_id") Long videoId) {
        return userService.deleteUserLikeVideo(userId, videoId);
    }

    @DeleteMapping("/{user_id}/course/{user_course_id}")
    public ResponseEntity<?> deleteUserCourse(@PathVariable("user_id") Long userId, @PathVariable("user_course_id") Long userCourseId) {
        return userService.deleteUserCourse(userCourseId);
    }

    @PostMapping("/{user_id}/course/{user_course_id}")
    public ResponseEntity<?> updateUserCourse(
            @PathVariable("user_id") Long userId,
            @PathVariable("user_course_id") Long userCourseId,
            @RequestBody CourseListDto courseListDto) {
        return userService.updateUserCourse(userId, userCourseId, courseListDto);
    }

}
