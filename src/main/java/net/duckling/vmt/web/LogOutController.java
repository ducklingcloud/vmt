/*
 * Copyright (c) 2008-2016 Computer Network Information Center (CNIC), Chinese Academy of Sciences.
 * 
 * This file is part of Duckling project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 */
package net.duckling.vmt.web;

import javax.servlet.http.HttpServletRequest;

import net.duckling.vmt.common.config.VmtConfig;
import net.duckling.vmt.common.util.UmtRequestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 退出登陆状态
 * @author lvly
 * @since 2013-6-21
 */
@Controller
@RequestMapping("/logout")
public class LogOutController {
	@Autowired
	private VmtConfig config;
	
	/**
	 * 把sesion置为无效，然后去登出umt
	 * @param request
	 * @return
	 */
	@RequestMapping
	public RedirectView logout(HttpServletRequest request){
		request.getSession().invalidate();
		return new RedirectView(UmtRequestUtils.getLogoutUrl(config, request));
	}

}
