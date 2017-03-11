<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- This area is for javascript that must remain in the JSP (ie. non cachable, POS specific data) --%>

var herc = {
  version: '11.2',
  config:{
    rootContext: '/equipment-rental-franchise-opportunities'
  },
  content: {
    ajaxFail: 'fail',
    close: 'close'
  },
  browser : {
  	 upgradeWarningShown : '${sessionScope.upgradeWarningShown}'
  }
}