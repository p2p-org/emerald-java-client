package io.emeraldpay.grpc;

public enum BlockchainType {
    BITCOIN,
    EVM_POW,
    EVM_POS;

    public static BlockchainType from(Chain chain) {
        if (chain == Chain.TESTNET_ROPSTEN
                || chain == Chain.POLYGON
                || chain == Chain.OPTIMISM
                || chain == Chain.BSC
                || chain == Chain.TESTNET_GOERLI
                || chain == Chain.ETHEREUM
        ) {
            return BlockchainType.EVM_POS;
        }
        if (chain == Chain.ETHEREUM_CLASSIC
                || chain == Chain.ARBITRUM
                || chain == Chain.FANTOM
                || chain == Chain.RSK
                || chain == Chain.TESTNET_KOVAN
                || chain == Chain.TESTNET_MORDEN
                || chain == Chain.TESTNET_RINKEBY
        ) {
            return BlockchainType.EVM_POW;
        }

        if (chain == Chain.BITCOIN
                || chain == Chain.TESTNET_BITCOIN
        ) {
            return BlockchainType.BITCOIN;
        }

        throw new IllegalArgumentException("Unknown type of blockchain: " + chain);
    }
}
