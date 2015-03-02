/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.principalmvl.lojackmykids.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.principalmvl.lojackmykids.meta.ContactMeta;
import com.principalmvl.lojackmykids.model.Contact;

/**
 * Servlet that registers a device, whose registration id is identified by
 * {@link #PARAMETER_REG_ID}.
 *
 * <p>
 * The client app should call this servlet everytime it receives a
 * {@code com.google.android.c2dm.intent.REGISTRATION C2DM} intent without an
 * error or {@code unregistered} extra.
 */
@SuppressWarnings("serial")
public class RegisterServlet extends BaseServlet {

	private static final String PARAMETER_REG_ID = "regId";
	private static final String PARAMETER_EMAIL = "email";
	private static final String PARAMETER_CREATEDATE = "createDate";
	private static final Logger log = Logger.getLogger(RegisterServlet.class
			.getName());
	private Contact contact;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {

		log.warning("[REGISTER SERVLET] Req:" + req.toString());
		String regId = getParameter(req, PARAMETER_REG_ID);
		String email = getParameter(req, PARAMETER_EMAIL);
		String createDate = getParameter(req, PARAMETER_CREATEDATE);

		// EntityManager emf = EMF.get().createEntityManager();

		contact = searchContact(email);
		log.warning("Search Contact: " + contact.toString());
		
		contact = createContact(regId, email, createDate);
		log.warning("Create Contact: " + contact.toString());
		
		Datastore.put(contact);

		// Datastore.register(regId); older way so we need to see if the new
		// stores the regid

		Enumeration<String> requestParameters = req.getParameterNames();

		while (requestParameters.hasMoreElements()) {
			String paramName = requestParameters.nextElement();
			log.warning("Request Parameter Name: " + paramName + ", Value - "
					+ req.getParameter(paramName));
		}

		setSuccess(resp);

	}

	private Contact createContact(String regId, String email, String createDate) {
		try {
			

			SimpleDateFormat formatter = new SimpleDateFormat(
					"EEEE, MMM dd, yyyy HH:mm:ss a");

			if (contact == null) {
				Key key = Datastore.createKey(Contact.class, email);
				contact.setKey(key);
				contact.setEmail(email);
				contact.setRegId(regId);
				contact.setCreateDate(formatter.parse(createDate));

			} else {
				contact.setRegId(regId);
				contact.setEmail(email);
				contact.setLastUpdateDate(formatter.parse(createDate));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contact;
	}

	private Contact searchContact(String email) {

		ContactMeta c = new ContactMeta();

		contact = Datastore.query(c).filter(c.email.equal(email)).asSingle();

		if (contact == null) {
			contact = new Contact();
		}

		return contact;
	}
}
