package com.ray.content_center.service.content;

import com.ray.content_center.domain.dto.ShareDTO;
import org.springframework.stereotype.Service;

/**
 * @author 张烈文
 */
@Service
public interface ShareService {

    ShareDTO findByShareId(Integer id);


}
