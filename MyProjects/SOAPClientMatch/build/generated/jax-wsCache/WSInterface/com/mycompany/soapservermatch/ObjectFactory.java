
package com.mycompany.soapservermatch;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.soapservermatch package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloMatchResponse_QNAME = new QName("http://soapservermatch.mycompany.com/", "helloMatchResponse");
    private final static QName _HelloMatch_QNAME = new QName("http://soapservermatch.mycompany.com/", "helloMatch");
    private final static QName _GetMatchesResponse_QNAME = new QName("http://soapservermatch.mycompany.com/", "getMatchesResponse");
    private final static QName _GetMatches_QNAME = new QName("http://soapservermatch.mycompany.com/", "getMatches");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.soapservermatch
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMatchesResponse }
     * 
     */
    public GetMatchesResponse createGetMatchesResponse() {
        return new GetMatchesResponse();
    }

    /**
     * Create an instance of {@link GetMatches }
     * 
     */
    public GetMatches createGetMatches() {
        return new GetMatches();
    }

    /**
     * Create an instance of {@link HelloMatchResponse }
     * 
     */
    public HelloMatchResponse createHelloMatchResponse() {
        return new HelloMatchResponse();
    }

    /**
     * Create an instance of {@link HelloMatch }
     * 
     */
    public HelloMatch createHelloMatch() {
        return new HelloMatch();
    }

    /**
     * Create an instance of {@link MatchEntry }
     * 
     */
    public MatchEntry createMatchEntry() {
        return new MatchEntry();
    }

    /**
     * Create an instance of {@link MatchMap }
     * 
     */
    public MatchMap createMatchMap() {
        return new MatchMap();
    }

    /**
     * Create an instance of {@link Match }
     * 
     */
    public Match createMatch() {
        return new Match();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloMatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservermatch.mycompany.com/", name = "helloMatchResponse")
    public JAXBElement<HelloMatchResponse> createHelloMatchResponse(HelloMatchResponse value) {
        return new JAXBElement<HelloMatchResponse>(_HelloMatchResponse_QNAME, HelloMatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservermatch.mycompany.com/", name = "helloMatch")
    public JAXBElement<HelloMatch> createHelloMatch(HelloMatch value) {
        return new JAXBElement<HelloMatch>(_HelloMatch_QNAME, HelloMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMatchesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservermatch.mycompany.com/", name = "getMatchesResponse")
    public JAXBElement<GetMatchesResponse> createGetMatchesResponse(GetMatchesResponse value) {
        return new JAXBElement<GetMatchesResponse>(_GetMatchesResponse_QNAME, GetMatchesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMatches }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapservermatch.mycompany.com/", name = "getMatches")
    public JAXBElement<GetMatches> createGetMatches(GetMatches value) {
        return new JAXBElement<GetMatches>(_GetMatches_QNAME, GetMatches.class, null, value);
    }

}
