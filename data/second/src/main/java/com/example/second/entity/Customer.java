package com.example.second.entity;

public record Customer(int id, String name, String email,String address, String city,String state,String country,String postCode)implements Entity  {
}

