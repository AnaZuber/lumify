package io.lumify.web.clientapi.codegen;

import io.lumify.web.clientapi.codegen.ApiException;
import io.lumify.web.clientapi.codegen.ApiInvoker;

import io.lumify.web.clientapi.model.TermMentionsResponse;
import io.lumify.web.clientapi.model.Element;
import io.lumify.web.clientapi.codegen.model.DetectedObjects;
import io.lumify.web.clientapi.model.ArtifactImportResponse;
import io.lumify.web.clientapi.codegen.model.GraphVertexSearchResult;
import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.*;

public class VertexApi {
  String basePath = "http://localhost:8889";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }
  
  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }
  
  public String getBasePath() {
    return basePath;
  }

  //error info- code: 404 reason: "Vertex not found" model: <none>
  public Element getByVertexId (String graphVertexId) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(graphVertexId == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/properties".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Element) ApiInvoker.deserialize(response, "", Element.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Element create (String conceptType, String visibilitySource) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(conceptType == null || visibilitySource == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/new".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(conceptType)))
      queryParams.put("conceptType", String.valueOf(conceptType));
    if(!"null".equals(String.valueOf(visibilitySource)))
      queryParams.put("visibilitySource", String.valueOf(visibilitySource));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Element) ApiInvoker.deserialize(response, "", Element.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Element setProperty (String graphVertexId, String propertyKey, String propertyName, String value, String visibilitySource, String justificationText, String sourceInfo, String metadata) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(graphVertexId == null || propertyKey == null || propertyName == null || value == null || visibilitySource == null || justificationText == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/property".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    if(!"null".equals(String.valueOf(propertyKey)))
      queryParams.put("propertyKey", String.valueOf(propertyKey));
    if(!"null".equals(String.valueOf(propertyName)))
      queryParams.put("propertyName", String.valueOf(propertyName));
    if(!"null".equals(String.valueOf(value)))
      queryParams.put("value", String.valueOf(value));
    if(!"null".equals(String.valueOf(visibilitySource)))
      queryParams.put("visibilitySource", String.valueOf(visibilitySource));
    if(!"null".equals(String.valueOf(justificationText)))
      queryParams.put("justificationText", String.valueOf(justificationText));
    if(!"null".equals(String.valueOf(sourceInfo)))
      queryParams.put("sourceInfo", String.valueOf(sourceInfo));
    if(!"null".equals(String.valueOf(metadata)))
      queryParams.put("metadata", String.valueOf(metadata));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Element) ApiInvoker.deserialize(response, "", Element.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public TermMentionsResponse getTermMentions (String graphVertexId, String propertyKey, String propertyName) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(graphVertexId == null || propertyKey == null || propertyName == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/term-mentions".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    if(!"null".equals(String.valueOf(propertyKey)))
      queryParams.put("propertyKey", String.valueOf(propertyKey));
    if(!"null".equals(String.valueOf(propertyName)))
      queryParams.put("propertyName", String.valueOf(propertyName));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (TermMentionsResponse) ApiInvoker.deserialize(response, "", TermMentionsResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public DetectedObjects getDetectedObjects (String graphVertexId, String propertyName, String workspaceId) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(graphVertexId == null || propertyName == null || workspaceId == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/detected-objects".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    if(!"null".equals(String.valueOf(propertyName)))
      queryParams.put("propertyName", String.valueOf(propertyName));
    if(!"null".equals(String.valueOf(workspaceId)))
      queryParams.put("workspaceId", String.valueOf(workspaceId));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (DetectedObjects) ApiInvoker.deserialize(response, "", DetectedObjects.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  //error info- code: 404 reason: "Vertex not found" model: <none>
  public Element setVisibility (String graphVertexId, String visibilitySource) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(graphVertexId == null || visibilitySource == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/visibility".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    if(!"null".equals(String.valueOf(visibilitySource)))
      queryParams.put("visibilitySource", String.valueOf(visibilitySource));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Element) ApiInvoker.deserialize(response, "", Element.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  //error info- code: 404 reason: "Artifact not found" model: <none>
  public String getHighlightedText (String graphVertexId, String propertyKey) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(graphVertexId == null || propertyKey == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/highlighted-text".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    if(!"null".equals(String.valueOf(propertyKey)))
      queryParams.put("propertyKey", String.valueOf(propertyKey));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (String) ApiInvoker.deserialize(response, "", String.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public ArtifactImportResponse importFile (String visibilitySource, File file) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(visibilitySource == null || file == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/import".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "multipart/form-data"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      hasFields = true;
      mp.field("visibilitySource", visibilitySource, MediaType.MULTIPART_FORM_DATA_TYPE);
      hasFields = true;
      com.sun.jersey.core.header.FormDataContentDisposition dispo = com.sun.jersey.core.header.FormDataContentDisposition
        .name("file")
        .fileName(file.getName())
        .size(file.length())
        .build();
      com.sun.jersey.multipart.FormDataBodyPart bodyPart = new com.sun.jersey.multipart.FormDataBodyPart(dispo, file, MediaType.MULTIPART_FORM_DATA_TYPE);
      mp.bodyPart(bodyPart);
      if(hasFields)
        postBody = mp;
    }
    else {
      formParams.put("visibilitySource", visibilitySource);}

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (ArtifactImportResponse) ApiInvoker.deserialize(response, "", ArtifactImportResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public void resolveTerm (String artifactId, String propertyKey, Integer mentionStart, Integer mentionEnd, String sign, String conceptId, String visibilitySource, String resolvedVertexId, String justificationText, String sourceInfo) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(artifactId == null || propertyKey == null || mentionStart == null || mentionEnd == null || sign == null || conceptId == null || visibilitySource == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/resolve-term".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(artifactId)))
      queryParams.put("artifactId", String.valueOf(artifactId));
    if(!"null".equals(String.valueOf(propertyKey)))
      queryParams.put("propertyKey", String.valueOf(propertyKey));
    if(!"null".equals(String.valueOf(mentionStart)))
      queryParams.put("mentionStart", String.valueOf(mentionStart));
    if(!"null".equals(String.valueOf(mentionEnd)))
      queryParams.put("mentionEnd", String.valueOf(mentionEnd));
    if(!"null".equals(String.valueOf(sign)))
      queryParams.put("sign", String.valueOf(sign));
    if(!"null".equals(String.valueOf(conceptId)))
      queryParams.put("conceptId", String.valueOf(conceptId));
    if(!"null".equals(String.valueOf(visibilitySource)))
      queryParams.put("visibilitySource", String.valueOf(visibilitySource));
    if(!"null".equals(String.valueOf(resolvedVertexId)))
      queryParams.put("resolvedVertexId", String.valueOf(resolvedVertexId));
    if(!"null".equals(String.valueOf(justificationText)))
      queryParams.put("justificationText", String.valueOf(justificationText));
    if(!"null".equals(String.valueOf(sourceInfo)))
      queryParams.put("sourceInfo", String.valueOf(sourceInfo));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public void unresolveTerm (String termMentionId) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(termMentionId == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/unresolve-term".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(termMentionId)))
      queryParams.put("termMentionId", String.valueOf(termMentionId));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public void resolveDetectedObject (String artifactId, String title, String conceptId, String visibilitySource, String graphVertexId, String justificationText, String sourceInfo, String originalPropertyKey, Double x1, Double x2, Double y1, Double y2) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(artifactId == null || title == null || conceptId == null || visibilitySource == null || x1 == null || x2 == null || y1 == null || y2 == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/resolve-detected-object".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(artifactId)))
      queryParams.put("artifactId", String.valueOf(artifactId));
    if(!"null".equals(String.valueOf(title)))
      queryParams.put("title", String.valueOf(title));
    if(!"null".equals(String.valueOf(conceptId)))
      queryParams.put("conceptId", String.valueOf(conceptId));
    if(!"null".equals(String.valueOf(visibilitySource)))
      queryParams.put("visibilitySource", String.valueOf(visibilitySource));
    if(!"null".equals(String.valueOf(graphVertexId)))
      queryParams.put("graphVertexId", String.valueOf(graphVertexId));
    if(!"null".equals(String.valueOf(justificationText)))
      queryParams.put("justificationText", String.valueOf(justificationText));
    if(!"null".equals(String.valueOf(sourceInfo)))
      queryParams.put("sourceInfo", String.valueOf(sourceInfo));
    if(!"null".equals(String.valueOf(originalPropertyKey)))
      queryParams.put("originalPropertyKey", String.valueOf(originalPropertyKey));
    if(!"null".equals(String.valueOf(x1)))
      queryParams.put("x1", String.valueOf(x1));
    if(!"null".equals(String.valueOf(x2)))
      queryParams.put("x2", String.valueOf(x2));
    if(!"null".equals(String.valueOf(y1)))
      queryParams.put("y1", String.valueOf(y1));
    if(!"null".equals(String.valueOf(y2)))
      queryParams.put("y2", String.valueOf(y2));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public void unresolveDetectedObject (String vertexId, String multiValueKey) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(vertexId == null || multiValueKey == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/unresolve-detected-object".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(vertexId)))
      queryParams.put("vertexId", String.valueOf(vertexId));
    if(!"null".equals(String.valueOf(multiValueKey)))
      queryParams.put("multiValueKey", String.valueOf(multiValueKey));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public GraphVertexSearchResult vertexSearch (String q, String filter, Integer offset, Integer size, String conceptType, Boolean leafNodes, String relatedToVertexId) throws ApiException {
    Object postBody = null;
    // verify required params are set
    if(filter == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/vertex/search".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if(!"null".equals(String.valueOf(q)))
      queryParams.put("q", String.valueOf(q));
    if(!"null".equals(String.valueOf(filter)))
      queryParams.put("filter", String.valueOf(filter));
    if(!"null".equals(String.valueOf(offset)))
      queryParams.put("offset", String.valueOf(offset));
    if(!"null".equals(String.valueOf(size)))
      queryParams.put("size", String.valueOf(size));
    if(!"null".equals(String.valueOf(conceptType)))
      queryParams.put("conceptType", String.valueOf(conceptType));
    if(!"null".equals(String.valueOf(leafNodes)))
      queryParams.put("leafNodes", String.valueOf(leafNodes));
    if(!"null".equals(String.valueOf(relatedToVertexId)))
      queryParams.put("relatedToVertexId", String.valueOf(relatedToVertexId));
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      if(hasFields)
        postBody = mp;
    }
    else {
      }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (GraphVertexSearchResult) ApiInvoker.deserialize(response, "", GraphVertexSearchResult.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  }
