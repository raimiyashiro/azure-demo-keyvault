package com.keyvault.secrets.quickstart;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

/**
 * Hello world!
 *
 * @doc https://docs.microsoft.com/pt-br/azure/key-vault/secrets/quick-create-java
 */
public class App {
    public static void main(String[] args) {
        String keyvaultUri = System.getenv("AKV-URI");

        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(keyvaultUri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        KeyVaultSecret secret = secretClient.getSecret(System.getenv("AKV-SECRET"));

        System.out.println(secret.getValue());
    }
}
