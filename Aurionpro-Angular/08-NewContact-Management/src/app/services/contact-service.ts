import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable,catchError,throwError } from "rxjs";
import { Icontact } from "../models/icontact";
import { Igroup } from "../models/igroup";

@Injectable
({
    providedIn: "root"
})

export class ContactService
{
    constructor(private httpClient:HttpClient){}

    private serverUrl:string="http://localhost:9000"

//Get all Contacts
    public getContacts():Observable<Icontact[]>{
        let dataUrl=`${this.serverUrl}/contacts`;
        return this.httpClient.get<Icontact[]>(dataUrl);
    }    

    public getContact(contactId:string):Observable<Icontact>{
        let dataUrl=`${this.serverUrl}/contacts/${contactId}`;
        return this.httpClient.get<Icontact>(dataUrl);
    }

    public addContact(contact:Icontact):Observable<Icontact>{
        let dataUrl=`${this.serverUrl}/contacts`;
        return this.httpClient.post<Icontact>(dataUrl,contact);
    }

    public getGroups():Observable<Igroup[]>{
        let dataUrl = `${this.serverUrl}/groups`;
        return this.httpClient.get<Igroup[]>(dataUrl);
    }

    public getGroupName(contact:Icontact):Observable<Igroup>{
        let dataUrl=`${this.serverUrl}/groups/${contact.groupId}`
        return this.httpClient.get<Igroup>(dataUrl);
    }

    public updateContact(contactId:string,contact:Icontact):Observable<Icontact>{
        let dataUrl=`${this.serverUrl}/contacts/${contactId}`;
        return this.httpClient.put<Icontact>(dataUrl,contact);
    }

    public deleteContact(contactId:string):Observable<{}>{
        let dataUrl=`${this.serverUrl}/contacts/${contactId}`;
        return this.httpClient.delete(dataUrl);
    }

}