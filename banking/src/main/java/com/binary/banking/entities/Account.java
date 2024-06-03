package com.binary.banking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name can not be blank")
    private String name;
    @NotNull(message = "Please choose an account type")
    private String accountType;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "name can not be blank") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "name can not be blank") String name) {
        this.name = name;
    }

    public @NotNull(message = "Please choose an account type") String getAccountType() {
        return accountType;
    }

    public void setAccountType(@NotNull(message = "Please choose an account type") String accountType) {
        this.accountType = accountType;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}