package com;


import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.Enumeration;

public class PolicyTest {
  public static void main(String args[]) {
    ProtectionDomain domain = "".getClass().getProtectionDomain();

    PermissionCollection pcoll = Policy.getPolicy().getPermissions(domain);

    Enumeration e = pcoll.elements();
    for (; e.hasMoreElements();) {
      Permission p = (Permission) e.nextElement();
      System.out.println(p);
      
    }
  }
}